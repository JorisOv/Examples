/*
 *	@(#)MouseBehavior.java 1.21 00/08/24 14:46:43
 *
 * Copyright (c) 1996-2000 Sun Microsystems, Inc. All Rights Reserved.
 *
 */


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.internal.J3dUtilsI18N;


/**
 * MouseBehavior
 *  
 * @version     1.21, 00/08/24 14:46:43
 **/

/**
 * Base class for all mouse manipulators (see MouseRotate, MouseZoom
 * and MouseTranslate for
 * examples of how to extend this base class). 
 */

public abstract class MouseBehavior extends Behavior
implements MouseListener, MouseMotionListener {

    private boolean listener = false;
    
  protected WakeupCriterion[] mouseEvents;
  protected WakeupOr mouseCriterion;
  protected int x, y;
  protected int x_last, y_last;
  protected TransformGroup transformGroup;
  protected Transform3D transformX;
  protected Transform3D transformY;
  protected Transform3D currXform;
  protected boolean buttonPress = false;
  protected boolean reset = false;
  protected boolean invert = false;
  protected boolean wakeUp = false;
  protected int flags = 0;
//      protected MouseEvent evt = null;

    // to queue the mouse events
    protected LinkedList mouseq;

  /**
   * Set this flag if you want to manually wakeup the behavior.
   */
  public static final int MANUAL_WAKEUP = 0x1;

  /** 
   * Set this flag if you want to invert the inputs.  This is useful when
   * the transform for the view platform is being changed instead of the 
   * transform for the object.
   */
  public static final int INVERT_INPUT = 0x2;

  /**
   * Creates a mouse behavior object with a given transform group.
   * @param transformGroup The transform group to be manipulated.
   */
  public MouseBehavior(TransformGroup transformGroup) {
    super();
    // need to remove old behavior from group 
    this.transformGroup = transformGroup;
    currXform = new Transform3D();
    transformX = new Transform3D();
    transformY = new Transform3D();
    reset = true;
  }

  /**
   * Initializes standard fields. Note that this behavior still
   * needs a transform group to work on (use setTransformGroup(tg)) and
   * the transform group must add this behavior.
   * @param format flags
   */
  public MouseBehavior(int format) {
    super();
    flags = format;
    currXform = new Transform3D();
    transformX = new Transform3D();
    transformY = new Transform3D();
    reset = true;
  }

    /**
     * Creates a mouse behavior that uses AWT listeners and behavior
     * posts rather than WakeupOnAWTEvent.  The behaviors is added to
     * the specified Component and works on the given TransformGroup.
     * A null component can be passed to specify the behaviors should use
     * listeners.  Components can then be added to the behavior with the
     * addListener(Component c) method.
     * @param c The Component to add the MouseListener and
     * MouseMotionListener to.
     * @param transformGroup The TransformGroup to operate on.
     * @since Java 3D 1.2.1
     */
    public MouseBehavior(Component c, TransformGroup transformGroup) {
	this(transformGroup);
	if (c != null) {
	    c.addMouseListener(this);
	    c.addMouseMotionListener(this);
	}
	listener = true;
    }

    /**
     * Creates a mouse behavior that uses AWT listeners and behavior
     * posts rather than WakeupOnAWTEvent.  The behavior is added to the
     * specified Component.  A null component can be passed to specify
     * the behavior should use listeners.  Components can then be added
     * to the behavior with the addListener(Component c) method.
     * Note that this behavior still needs a transform
     * group to work on (use setTransformGroup(tg)) and the transform
     * group must add this behavior.
     * @param flags interesting flags (wakeup conditions).
     * @since Java 3D 1.2.1
     */
    public MouseBehavior(Component c, int format) {
	this(format);
	if (c != null) {
	    c.addMouseListener(this);
	    c.addMouseMotionListener(this);
	}
	listener = true;
    }
 
  /** 
   * Swap a new transformGroup replacing the old one. This allows 
   * manipulators to operate on different nodes.
   * 
   * @param transformGroup The *new* transform group to be manipulated.
   */
  public void setTransformGroup(TransformGroup transformGroup){
    // need to remove old behavior from group 
    this.transformGroup = transformGroup;
    currXform = new Transform3D();
    transformX = new Transform3D();
    transformY = new Transform3D();
    reset = true;
  }

  /**
   * Return the transformGroup on which this node is operating
   */
  public TransformGroup getTransformGroup() {
    return this.transformGroup;
  }

  /** Initializes the behavior.
   */

  public void initialize() {
    mouseEvents = new WakeupCriterion[3];
    if (!listener) {
	mouseEvents[0] = new WakeupOnAWTEvent(MouseEvent.MOUSE_DRAGGED);
	mouseEvents[1] = new WakeupOnAWTEvent(MouseEvent.MOUSE_PRESSED);
	mouseEvents[2] = new WakeupOnAWTEvent(MouseEvent.MOUSE_RELEASED);
    }
    else {
	mouseEvents[0] = new WakeupOnBehaviorPost(this,
						  MouseEvent.MOUSE_DRAGGED);
	mouseEvents[1] = new WakeupOnBehaviorPost(this,
						  MouseEvent.MOUSE_PRESSED);
	mouseEvents[2] = new WakeupOnBehaviorPost(this,
						  MouseEvent.MOUSE_RELEASED);
	mouseq = new LinkedList();
    }
    mouseCriterion = new WakeupOr(mouseEvents);
    wakeupOn (mouseCriterion);
    x = 0;
    y = 0;
    x_last = 0;
    y_last = 0;
  }
  
  /** 
   * Manually wake up the behavior. If MANUAL_WAKEUP flag was set upon 
   * creation, you must wake up this behavior each time it is handled.
   */

  public void wakeup()
  {
    wakeUp = true;
  }

  /**
   * Handles mouse events
   */
  public void processMouseEvent(MouseEvent evt) {
    if (evt.getID()==MouseEvent.MOUSE_PRESSED) {
      buttonPress = true;
      return;
    }
    else if (evt.getID()==MouseEvent.MOUSE_RELEASED){
      buttonPress = false;
      wakeUp = false;
    }    
    else if (evt.getID() == MouseEvent.MOUSE_MOVED) {
      // Process mouse move event
    }
  }
  
  /**
   * All mouse manipulators must implement this.
   */
  public abstract void processStimulus (Enumeration criteria);

    /**
     * Adds this behavior as a MouseListener and MouseMotionListener to
     * the specified component.  This method can only be called if
     * the behavior was created with one of the constructors that takes
     * a Component as a parameter.
     * @param c The component to add the MouseListener and
     * MouseMotionListener to.
     * @exception IllegalStateException if the behavior was not created
     * as a listener
     * @since Java 3D 1.2.1
     */
    public void addListener(Component c) {
	if (!listener) {
	    throw new IllegalStateException(J3dUtilsI18N.getString("Behavior0"));
	}
	c.addMouseListener(this);
	c.addMouseMotionListener(this);
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
// 	System.out.println("mousePressed");

	// add new event to the queue
	// must be MT safe
	synchronized (mouseq) {
	    mouseq.add(e);
	    // only need to post if this is the only event in the queue
	    if (mouseq.size() == 1) postId(MouseEvent.MOUSE_PRESSED);
	}
    }

    public void mouseReleased(MouseEvent e) {
// 	System.out.println("mouseReleased");

	// add new event to the queue
	// must be MT safe
	synchronized (mouseq) {
	    mouseq.add(e);
	    // only need to post if this is the only event in the queue
	    if (mouseq.size() == 1) postId(MouseEvent.MOUSE_RELEASED);
	}
    }

    public void mouseDragged(MouseEvent e) {
// 	System.out.println("mouseDragged");

	// add new event to the to the queue
	// must be MT safe.
	synchronized (mouseq) {
	    mouseq.add(e);
	    // only need to post if this is the only event in the queue
	    if (mouseq.size() == 1) postId(MouseEvent.MOUSE_DRAGGED);
	}
    }

    public void mouseMoved(MouseEvent e) {}
}


