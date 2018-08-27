package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import twitter4j.Status;

import java.awt.*;

public class MapMakerColor extends MapMarkerSimple {


    public MapMakerColor(Layer layer, Coordinate coord, Color color) {
        super(layer, coord);
        setBackColor(color);
    }
}
