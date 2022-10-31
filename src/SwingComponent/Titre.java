package SwingComponent;

import java.awt.Dimension;
import java.awt.Color;

@SuppressWarnings("serial")
public class Titre extends Label {

	public Titre(String s) {
		super(s);
	}

	public Titre(String s, Color bg, Color fg) {
		super(s);
		this.setOpaque(true);
		this.setBackground(bg);
		this.setForeground(fg);
	}

	public Titre() {
		super();
	}

	public Titre(String s, int size) {
		super(s, size);
	}

	public Dimension getMaximumSize() {
		Dimension d = super.getMaximumSize();
		d.width = Integer.MAX_VALUE;
		;
		return d;
	}
}
