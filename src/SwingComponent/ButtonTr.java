package SwingComponent;

import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class ButtonTr extends TitreButton{
	
	public ButtonTr(String s){
		super(s);
		this.setFont(new Font("serif", Font.ITALIC, 20));
	}
	public Dimension getMaximumSize(){
		Dimension d = super.getMaximumSize();
		 d.height= d.height-30;
		  d.width =400;
		return d;
		}
}
