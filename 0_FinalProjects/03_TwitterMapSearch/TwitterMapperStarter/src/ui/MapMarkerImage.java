package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapMarkerImage extends MapMarkerSimple {
    private BufferedImage img;
    private String text;
    private String url;

    public MapMarkerImage(Layer layer, Coordinate coord, BufferedImage image, String text, String url) {
        super(layer, coord);
        this.img = image;
        this.text = text;
        this.url = url;
    }

    public String getUrl() { return url; }

    public BufferedImage getImg() {
        return img;
    }

    public String getText() {
        return text;
    }

    @Override
    public void paint(Graphics g, Point position, int radius) {
        int size = radius * 2;
        if (g instanceof Graphics2D && this.getBackColor() != null) {
            Graphics2D g2 = (Graphics2D)g;
            Composite oldComposite = g2.getComposite();
            g2.setComposite(AlphaComposite.getInstance(3));
            g2.setPaint(this.getBackColor());
            g.fillOval(position.x - radius, position.y - radius, size, size);
            g2.setComposite(oldComposite);
        }
//           g.setColor(this.getColor());
//           g.drawOval(position.x - radius, position.y - radius, size, size);
//           if (this.getLayer() == null || this.getLayer().isVisibleTexts().booleanValue()) {
//               this.paintText(g, position);
//           }
        g.drawImage(this.img, position.x - radius, position.y - radius, size, size, null);
        this.paintText(g, position);
    }

}