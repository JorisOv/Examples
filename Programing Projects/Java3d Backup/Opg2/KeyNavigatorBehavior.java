/*
 *	@(#)KeyNavigatorBehavior.java 1.7 00/08/24 14:47:31
 *
 * Copyright (c) 1996-2000 Sun Microsystems, Inc. All Rights Reserved.
 * MODIFIED
 */

//package java3Dcourse;

import java.awt.event.*;
import java.awt.AWTEvent;
import java.util.Enumeration;
import java.awt.Component;
import javax.vecmath.*;
import javax.media.j3d.*;
//import com.sun.j3d.internal.J3dUtilsI18N;

/**
 * This class is a simple behavior that invokes the KeyNavigator
 * to modify the view platform transform.
 */
public class KeyNavigatorBehavior extends Behavior {
    private WakeupCriterion       w1 = new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED);
    private WakeupCriterion       w2 = new WakeupOnAWTEvent(KeyEvent.KEY_RELEASED);
    private WakeupOnElapsedFrames w3 = new WakeupOnElapsedFrames(0);
    private WakeupCriterion[] warray = { w1, w2, w3 };
    private WakeupCondition        w = new WakeupOr(warray);
    private KeyEvent eventKey;
    private KeyNavigator keyNavigator;
    private boolean listener = false;


    /**
     * Constructs a new key navigator behavior node that operates
     * on the specified transform group.
     * @param targetTG the target transform group
     */
    public KeyNavigatorBehavior(TransformGroup targetTG) {
	     keyNavigator = new KeyNavigator(targetTG);
    }

    /**
     *  Override Behavior's initialize method to setup wakeup criteria.
     */
    public void initialize() {
	  // Establish initial wakeup criteria
      if (listener) {
         w1 = new WakeupOnBehaviorPost(this, KeyEvent.KEY_PRESSED);
         w2 = new WakeupOnBehaviorPost(this, KeyEvent.KEY_RELEASED);
         warray[0] = w1;
         warray[1] = w2;
         w = new WakeupOr(warray);
	    }
	    wakeupOn(w);
    }

    /**
     *  Override Behavior's stimulus method to handle the event.
     */
    public void processStimulus(Enumeration criteria) {
      WakeupOnAWTEvent ev;
      WakeupCriterion genericEvt;
      AWTEvent[] events;
	    boolean sawFrame = false;
      //System.out.println("processStimulus");
	    while (criteria.hasMoreElements()) {
	       genericEvt = (WakeupCriterion) criteria.nextElement();
	       if (genericEvt instanceof WakeupOnAWTEvent) {
	         //System.out.println("WakeupOnAWTEvent");
           ev = (WakeupOnAWTEvent) genericEvt;
           events = ev.getAWTEvent();
           processAWTEvent(events);
	       } else if (genericEvt instanceof WakeupOnElapsedFrames && eventKey != null) {
	         //System.out.println("WakeupOnElapsedFrames, eventKey != null");		        
		       sawFrame = true;
	       } else if (genericEvt instanceof WakeupOnElapsedFrames && eventKey == null) {
	         // situation before first key event
	         //System.out.println("WakeupOnElapsedFrames, eventKey == null");		        
		       //sawFrame = true;
	       } else  {
	          System.out.println("UNKNOWN WAKEUP EVENT: " + genericEvt);
	       }
	    }
	    if (sawFrame)
	       keyNavigator.integrateTransformChanges();

    	// Set wakeup criteria for next time
	    wakeupOn(w);
    }

    /**
     *  Process a keyboard event
     */
    private void processAWTEvent(AWTEvent[] events) {
	    for (int loop = 0; loop < events.length; loop++) {
	        if (events[loop] instanceof KeyEvent) {
		         eventKey = (KeyEvent) events[loop];
             //  change the transformation; for example to zoom
            if (eventKey.getID() == KeyEvent.KEY_PRESSED ||
                eventKey.getID() == KeyEvent.KEY_RELEASED) 
            {
		          // System.out.println("Keyboard is hit! " + eventKey);
		           keyNavigator.processKeyEvent(eventKey);
            }
          }
      }
    }




}
