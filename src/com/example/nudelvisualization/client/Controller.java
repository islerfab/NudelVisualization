package com.example.nudelvisualization.client;

// import com.example.nudelvisualization.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
// import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
// import com.google.gwt.event.dom.client.KeyCodes;
// import com.google.gwt.event.dom.client.KeyUpEvent;
// import com.google.gwt.event.dom.client.KeyUpHandler;
// import com.google.gwt.user.client.Window;
// import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
// import com.google.gwt.user.client.ui.CheckBox;
// import com.google.gwt.user.client.ui.DialogBox;
// import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
// import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
// import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;
// import com.google.gwt.user.client.ui.TextBox;
// import com.google.gwt.user.client.ui.VerticalPanel;
// import com.google.gwt.user.client.ui.Widget;
// import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.dom.client.Style.Unit;
//import com.google.gwt.user.client.ui.DockLayoutPanel;
//import com.google.gwt.user.client.ui.RootLayoutPanel;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Controller implements EntryPoint {

	
    private HorizontalPanel filterHorizontalPanel = new HorizontalPanel();
    //private TextBox tbYearStart = new TextBox();
    //private TextBox tbYearEnd = new TextBox();
    private Grid gridYear = new Grid(3, 2);
    private Button buttonUpdateFilter = new Button("OK");
    private ListBox lbArea = new ListBox(true);
    private ListBox lbYear = new ListBox(true);
    private ListBox lbDataSeries = new ListBox(true);
    private ListBox lbItems = new ListBox(true);
    private Filter filter = null;
    /*private ArrayList<String> selectedAreas = new ArrayList<String>();
    private ArrayList<String> selectedYears = new ArrayList<String>();
    private ArrayList<String> selectedDataSeries = new ArrayList<String>();
    private ArrayList<String> selectedItems = new ArrayList<String>();*/
    private Configuration config = null; 

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	/*private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";*/
	
	 /**
	 * Updates the Filter. Executed when user clicks the Update Button
	 * @return 
	 */
	private final void updateFilter(ListBox lbArea, ListBox lbYear, ListBox lbDataSeries, ListBox lbItems){
		
		config = new Configuration();
		
		for (int i = 0; i < lbArea.getItemCount(); i++){
			if (lbArea.isItemSelected( i) == true){
				// selectedAreas.add(lbArea.getValue(i));
				config.addArea(lbArea.getValue(i));
			}
		}
		
		for (int j= 0; j<lbYear.getItemCount(); j++){
			if (lbYear.isItemSelected(j)){
				// selectedYears.add(lbYear.getValue(j).replaceAll("\\s", ""));
				config.addYear(lbYear.getValue(j).replaceAll("\\s", ""));
			}
		}
		
		for (int n = 0; n<lbDataSeries.getItemCount(); n++){
			if(lbDataSeries.isItemSelected(n)){
				// selectedDataSeries.add(lbDataSeries.getValue(n));
				config.addDataSeries(lbDataSeries.getValue(n));
			}
		}
		
		for (int m= 0; m< lbItems.getItemCount(); m++){
			if(lbItems.isItemSelected(m)){
				// selectedItems.add(lbItems.getValue(m));
				config.addItem(lbItems.getValue(m));
			}
		}
		
		// initialize visualization
		filter.visualizeAsTable(config);
		
	}
	
	/*public ArrayList<String> getSelectedAreas(){
		return this.selectedAreas;
	}
	
	public ArrayList<String> getSelectedItems(){
		return this.selectedItems;
	}
	
	public ArrayList<String> getSelectedDataSeries(){
		return this.selectedDataSeries;
	}
	
	public ArrayList<String> getSelectedYears(){
		return this.selectedYears;
	}*/
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		//create ListBox for Area
		//for (int i = 0; i < filter.area.size(); i++){
		//	lbArea.addItem(filter.area.get(i).getName());
		//}
	    
	    
//		for (int j = 0; j < filter.getArea().size(); j++) {
//			cb.add(new CheckBox(filter.getArea().get(j).getName()));
//		}
		
//		for (int j = 0; j < cb.size(); j++) {
//			cb.get(j).setValue(false);
//		}
	    

		// Hook up a handler to find out when it's clicked.
//		for (int j = 0; j < cb.size(); j++){
//			cb.get(j).addClickHandler(new ClickHandler() {
//				@Override
//				public void onClick(ClickEvent event) {
//					boolean checked = ((CheckBox) event.getSource()).getValue();
//					Window.alert("It is " + (checked ? "" : "not ") + "checked");
//				}
//			});
//		}
//	    // Add it to the root panel.
//		for (int i = 0; i<cb.size(); i++){
//	    RootPanel.get().add(cb.get(i));
//		}
		
//
		filter = new Filter(lbArea, lbItems);
		filter.init();
		
		//Listbox Year
		for (int i = 0; i< filter.getYears().size(); i++){
			lbYear.addItem(filter.getYears().get(i).getYear() + "       ");
		}
		lbYear.setVisibleItemCount(10);
		
		//Listbox DataSeries
		for (int i = 0; i<filter.getDataSeries().size(); i++){
			lbDataSeries.addItem(filter.getDataSeries().get(i).getName(), filter.getDataSeries().get(i).getID());
		}
		lbDataSeries.setVisibleItemCount(10);
		
	    // Button to update Filter
	    buttonUpdateFilter.addClickHandler(new ClickHandler() {
	    	
	    	@Override
	    	public void onClick(ClickEvent event) {
	    		updateFilter(lbArea, lbYear, lbDataSeries, lbItems );
	    	}
	    });
	    
	    
	    
	    filterHorizontalPanel.add(gridYear);
	    filterHorizontalPanel.add(lbArea);
	    filterHorizontalPanel.add(lbYear);
	    filterHorizontalPanel.add(lbDataSeries);
	    filterHorizontalPanel.add(lbItems);

	    filterHorizontalPanel.add(buttonUpdateFilter);
	    
	    RootPanel.get("filterContainer").add(filterHorizontalPanel);
	    
	    
	    MapOptions options  = MapOptions.create() ;

	    double lngCenter = 5;
		double latCenter = 5;
		options.setCenter(LatLng.create( latCenter, lngCenter ));   
	    options.setZoom( 0 ) ;
	    options.setMapTypeId( MapTypeId.ROADMAP );
	    options.setDraggable(true);
	    options.setMapTypeControl(true);
	    options.setScaleControl(true) ;
	    options.setScrollwheel(true) ;

	    SimplePanel widg = new SimplePanel() ;

	    widg.setSize("50%","50%");

	    GoogleMap theMap = GoogleMap.create( widg.getElement(), options ) ;

	    RootLayoutPanel.get().add( widg ) ; 
		
	    
	}
}
