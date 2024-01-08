/*
 *	@(#)MouseBehaviorCallback.java 1.4 00/03/20 08:56:34
 *
 * Copyright (c) 1996-2000 Sun Microsystems, Inc. All Rights Reserved.
 *
 */

/**
 * @Author Paul Byrne
*/



import javax.media.j3d.Transform3D;

/**
 * The MouseBehaviorCallback interface allows a class to be notified
 * when the transform is changed by one of the MouseBehaviors. The
 * class that is interested in transform changes implements this
 * interface, and the object created with that class is registered
 * with the desired subclass of MouseBehavior using the
 * <code>setupCallback</code> method. When the transform changes, the
 * registered object's <code>transformChanged</code> method is
 * invoked.
 */

public interface MouseBehaviorCallback {

    public final static int ROTATE=0;
    public final static int TRANSLATE=1;
    public final static int ZOOM=2;

    /**
      * Classes implementing this interface that are registered with
      * one of the MouseBehaviors will be called every time the
      * behavior updates the Transform
      * @param type will be one of ROTATE, TRANSLATE or ZOOM
      */
    public void transformChanged( int type, Transform3D transform );
}
