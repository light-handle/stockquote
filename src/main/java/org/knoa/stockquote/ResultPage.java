package org.knoa.stockquote;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class ResultPage extends WebPage
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResultPage(int stockValue)
	{
		add(new Label("v", Integer.toString(stockValue)));
	}
}
