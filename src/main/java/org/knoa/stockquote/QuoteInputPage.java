package org.knoa.stockquote;

//import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.Model;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.extensions.yui.calendar.DatePicker;

public class QuoteInputPage extends WebPage
{
	private static final long serialVersionUID = 1L;
	
	private Model<String> symModel;
	private Model<Date> dateModel;
	//private int randomId;
	
	public QuoteInputPage()
	{
		FeedbackPanel feedback = new FeedbackPanel("msgs");
		add(feedback);
	/*	randomId = new Random().nextInt();
		System.out.println("Constructing Page: "+ randomId);*/
		Form<Void> form = new Form<Void> ("f")
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit()
			{
				String symbol = symModel.getObject();
				System.out.println(symModel.getObject());
				Date date = dateModel.getObject();
				if(symbol != null)
				{
					ResultPage resultPage = new ResultPage((symbol + date.toString()).hashCode());
					setResponsePage(resultPage);
				}
			}
		};
		add(form);
		symModel = new Model<String>();
	//	TextField<String> sym = new TextField<String>("sym", symModel);
		List<String> symbols = new ArrayList<String>();
		symbols.add("MSFT");
		symbols.add("IBM");
		symbols.add("GOOG");
		DropDownChoice<String> sym = new DropDownChoice<String>("sym", symModel, symbols);
		form.add(sym);
		dateModel = new Model<Date> (new Date());
		TextField<Date> quoteDate = new TextField<Date>("quoteDate", dateModel, Date.class);
		quoteDate.setRequired(true);
		quoteDate.add(new DatePicker());
		form.add(quoteDate);
	}
}
