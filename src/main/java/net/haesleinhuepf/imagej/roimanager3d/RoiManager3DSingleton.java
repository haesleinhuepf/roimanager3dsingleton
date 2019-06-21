package net.haesleinhuepf.imagej.roimanager3d;


import ij.IJ;
import ij.ImagePlus;
import ij.macro.Functions;
import mcib_plugins.tools.RoiManager3D_2;
import org.scijava.command.Command;
import org.scijava.plugin.Plugin;

import java.rmi.server.RemoteObjectInvocationHandler;
import java.util.HashMap;

/**
 * A singleton implementation for the 3D ROI Manager of the 3D ImageJ Suite
 *
 * Author: @haesleinhuepf
 * June 2019
 */
@Plugin(type = Command.class, menuPath = "Plugins>3D>3D ROI Manager (Singleton)")
public class RoiManager3DSingleton implements Command{

    private static RoiManager3D_2 roiManager = null;

    @Override
    public void run() {
        if (roiManager == null) {
            roiManager = new RoiManager3D_2();
        } else {
            Functions.registerExtensions(roiManager);
        }
        roiManager.show();
    }
}
