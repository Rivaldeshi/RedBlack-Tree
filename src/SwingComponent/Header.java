package SwingComponent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

@SuppressWarnings("serial")
public class Header extends Panel {

	public Header(Text a, List<TitreButton> heads) {
		super();
		Panel p = new Panel();
		p.setLayout(new FlowLayout());

		p.setPreferredSize(new Dimension(200, 30));
		this.setPreferredSize(new Dimension(200, 50));

		p.add(a);
		for (TitreButton btn : heads)
			p.add(btn);

		this.add(p);
		

	}

}
