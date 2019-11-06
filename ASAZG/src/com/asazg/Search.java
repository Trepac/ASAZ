package com.asazg;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingWorker;

public class Search extends SwingWorker<Void, Void> {
	
	private String from;
	private String to;
	private String date;
	private String dateLimit;
	private String LogicB;
	private String LogicA;
	private ArrayList<String[]> AdditionalFilters = new ArrayList<String[]>();
	private ArrayList<String> myStrings = new ArrayList<String>();
	private String[] resultOfSearch;
	private int numberOfAdditionalFilters;
	private boolean truth = false;
	private List<String> fromEntries = new ArrayList<String>();
	private List<String> toEntries = new ArrayList<String>();
	private List<String> fromOrEntries = new ArrayList<String>();
	private List<String> toOrEntries = new ArrayList<String>();
	private List<String> foundEntries = new ArrayList<String>();
	private Boolean dateRequest = false;
	private Boolean fromRequest = false;
	private Boolean toRequest = false;
		
	public Search(ArrayList<String> myStrings, String from, String to,String date, String date2,String LogicA ,String LogicB , ArrayList<String[]> AdditionalFilters, int y){
		 this.myStrings = myStrings;
		 this.from = from;
		 this.to = to ;
		 this.date = date;
		 this.AdditionalFilters = AdditionalFilters;
		 this.dateLimit = date2;
		 this.LogicB = LogicB;
		 this.LogicA = LogicA;
		this.numberOfAdditionalFilters =y;
	}
	
	public boolean keyFinder(String keyString, String compareKey){
		Pattern keycheckerPattern = Pattern.compile("\\b^[A-F0-9]{11}\\b");
		Matcher matKey = keycheckerPattern.matcher(keyString);
		 while (matKey.find()){
			 if(keyString.equals(compareKey)){
				 return true;
			 }
			
			 }
		 return false;
	}
	
	 public void proccessData(){
		 Pattern pattern3 = Pattern.compile(": ");
		 String from=""; 
		 String to="";
		 String date="";
		 String dateLimit ="";
		 String LogicA="" ;
		 String LogicB="";
		 String LogicC ="";
		 Pattern patTime = Pattern.compile(" ");
		 int repeater =0;
		
		 if(numberOfAdditionalFilters==0){
			 repeater = 1;
		 }else{ repeater = 1 + numberOfAdditionalFilters;}
				 
		 for(int h = 1; h<= repeater ; h++ ){
			fromEntries.clear(); 
			toEntries.clear(); 
			fromOrEntries.clear(); 
			toOrEntries.clear(); 
		if(h==1){
		
			from = this.from;
			to = this.to;
			date = this.date;
			dateLimit = this.dateLimit;
			LogicA = this.LogicA;
			LogicB = this.LogicB;
			LogicC = "And";
		}else{
			
			String[] buffer = new String[7];
			buffer = AdditionalFilters.get(h-2);
			from = buffer[1];
			to = buffer[2];
			date = buffer[3];
			dateLimit = buffer[4];
			LogicA = buffer[5];
			LogicB = buffer[6];
			LogicC =buffer[0];
		}	
		if(date.equals("")== false){
				 dateRequest = true;}
			
			 if(from.equals("")&&to.equals("")&& date.equals("")){
				
				 About window = new About(3);
					window.Window(3);
				 return   ;
			 } 
		 for(int i = 0; i<= myStrings.size() - 1 ; i++ ){
			 
			 
			 if(from.equals("")== false){
				 fromRequest = true;
			 }
			 if(to.equals("")== false){
				 toRequest = true;
			 }
			 Pattern serverName = Pattern.compile(" ");
				String[] serverGetter = serverName.split(myStrings.get(i));
				Pattern pattern2 = Pattern.compile(" "+serverGetter[3]+" " );
			 String[] serverSpliter = pattern2.split(myStrings.get(i));
		  String[] dvojbodkaSpliter = pattern3.split(serverSpliter[1]);
		  String[] dateSpliter = patTime.split(serverSpliter[0]);
		 
		  String[] dateTextA = patTime.split(date);
		  String[] dateTextB = patTime.split(dateLimit);
		
		  if(dateRequest){
			  if(dateLimit.equals("")){
				  if(dateTextA[1].equals(dateSpliter[0]) && dateTextA[2].equals(dateSpliter[1])){
					 
					 if(LogicB.equals("And")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
					 if(LogicB.equals("Or")){fromRequest = false;toRequest = false;getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
				  }else{if(LogicB.equals("Or")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
				  if(LogicB.equals("Not")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}}
			  }
			  if(!dateLimit.equals("")){
			  if(monthToNumber(dateTextA[1]) == monthToNumber(dateTextB[1])){
				  if(dateTextA[1].equals(dateSpliter[0])){
				  int m = Integer.parseInt(dateTextA[2]);
				  int n = Integer.parseInt(dateTextB[2]);
				  for( int k=m ;k<=n; k++){
					  if(numberToString(k).equals(dateSpliter[1])){
						  if(LogicB.equals("And")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
							 if(LogicB.equals("Or")){fromRequest = false;toRequest = false;getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
						  }else{if(LogicB.equals("Or")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
						  if(LogicB.equals("Not")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}}
				  }}}}
			  
			  if(!dateLimit.equals("")){
				  if(monthToNumber(dateTextA[1]) < monthToNumber(dateTextB[1])){
					  int o = monthToNumber(dateTextA[1]);
					  int p = monthToNumber(dateTextB[1]);
					  int m = 1;
					  int n = 31;
					  for(int l=o;l<=p;l++){
						  if(numberToMonth(l).equals(dateSpliter[0])){
					  if(l==o){m = Integer.parseInt(dateTextA[2]); n=31;}
					  if(l==p){m=1;n = Integer.parseInt(dateTextB[2]);}
					 
					  
					  for( int k=m ;k<=n; k++){
						  if(numberToString(k).equals(dateSpliter[1])){
							  if(LogicB.equals("And")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
								 if(LogicB.equals("Or")){fromRequest = false;toRequest = false;getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
							  }else{if(LogicB.equals("Or")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
							  if(LogicB.equals("Not")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}}
					  }}}}}
			  
			  if(!dateLimit.equals("")){
				  if(monthToNumber(dateTextA[1]) > monthToNumber(dateTextB[1])){
					  int o = monthToNumber(dateTextA[1]);
					  int p = monthToNumber(dateTextB[1]);
					  int m = 1;
					  int n = 31;
					  for(int l=o;l<=12;l++){
						  if(numberToMonth(l).equals(dateSpliter[0])){
					  if(l==o){m = Integer.parseInt(dateTextA[2]); n=31;}
					  if(l==p){m=1;n = Integer.parseInt(dateTextB[2]);}
					
					  
					  for( int k=m ;k<=n; k++){
						  if(numberToString(k).equals(dateSpliter[1])){
							  if(LogicB.equals("And")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
								 if(LogicB.equals("Or")){fromRequest = false;toRequest = false;getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
							  }else{if(LogicB.equals("Or")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
							  if(LogicB.equals("Not")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}}
					  }}}
					  for(int l=1;l<=p;l++){
						  if(numberToMonth(l).equals(dateSpliter[0])){
					  if(l==o){m = Integer.parseInt(dateTextA[2]); n=31;}
					  if(l==p){m=1;n = Integer.parseInt(dateTextB[2]);}
					  
					  
					  for( int k=m ;k<=n; k++){
						  if(numberToString(k).equals(dateSpliter[1])){
							  if(LogicB.equals("And")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
								 if(LogicB.equals("Or")){fromRequest = false;toRequest = false;getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
							  }else{if(LogicB.equals("Or")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
							  if(LogicB.equals("Not")){getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}}
					  }}}
				  }}
			
		  }else{getData(dvojbodkaSpliter,dateSpliter,from,to,LogicA);}
		  double  progress = 0;
		  if(i+1 != myStrings.size()){
			  progress = ((i+1)*1.0/myStrings.size())*100/2; }else {progress = 50;}
		 
		  setProgress((int)progress); 
		 }
		
			  Pattern dividerPattern = Pattern.compile(":");
			  
			 
			  if(LogicA.equals("And")||LogicA.equals("Not")){
			
			  for(int i=0; i < fromEntries.size();i++){
			  	String[] fromCompare = dividerPattern.split(fromEntries.get(i)) ;
			  	for(int j=0;j< toEntries.size();j++){
		
				String[] toCompare =  dividerPattern.split(toEntries.get(j));
				if(fromCompare[3].equals(toCompare[3])){
					
					if(LogicC.equals("And")||LogicC.equals("Or")){
						foundEntries.add(fromCompare[0]+" "+fromCompare[1]+" From: "+fromCompare[2]+" To: "+toCompare[2]+" Key: "+fromCompare[3]/*+" tomKey: "+toCompare[3] */);
					}
					if(LogicC.equals("Not")){
						int q;
						for(q = 1; q <= foundEntries.size() - 1;q++){
						if(foundEntries.get(q).equals(fromCompare[0]+" "+fromCompare[1]+" From: "+fromCompare[2]+" To: "+toCompare[2]+" Key: "+fromCompare[3])){
							foundEntries.remove(q);}
						}
					}
						}  
			  } 
			  	 double  progress = 0;
				  if(i+1 != fromEntries.size()){
				
					  progress = (((i+1)*1.0/fromEntries.size())*100/2)+50; }else {progress = 100;}
				 
				  setProgress((int)progress);
			  }
		
			  }
			  
			  if(LogicA.equals("Or")){
				  for(int i=0; i < fromEntries.size();i++){
				
				  	String[] fromCompare = dividerPattern.split(fromEntries.get(i)) ;
				  	for(int j=0;j< toOrEntries.size();j++){
				 
					String[] toCompare =  dividerPattern.split(toOrEntries.get(j));
					if(fromCompare[3].equals(toCompare[3])){
						if(LogicC.equals("And")||LogicC.equals("Or")){
							
							foundEntries.add(fromCompare[0]+" "+fromCompare[1]+" From: "+fromCompare[2]+" To: "+toCompare[2]+" Key: "+fromCompare[3]/*+" tomKey: "+toCompare[3] */);
						}
						if(LogicC.equals("Not")){
							int q;
							for(q = 1; q <= foundEntries.size() - 1;q++){
							if(foundEntries.get(q).equals(fromCompare[0]+" "+fromCompare[1]+" From: "+fromCompare[2]+" To: "+toCompare[2]+" Key: "+fromCompare[3])){
								foundEntries.remove(q);}
							}
						}
						
							}  
				  }
				  	double  progress = 0;
					  if(i+1 != fromEntries.size()){
						  progress = (((i+1)*1.0/fromEntries.size())*100/4)+50; }else {progress = 75;}
					 
					  setProgress((int)progress);
				  }
				  
				  for(int i=0; i < fromOrEntries.size();i++){
					
					  	String[] fromCompare = dividerPattern.split(fromOrEntries.get(i)) ;
					  	for(int j=0;j< toEntries.size();j++){
					
						String[] toCompare =  dividerPattern.split(toEntries.get(j));
						if(fromCompare[3].equals(toCompare[3])){
							if(LogicC.equals("And")||LogicC.equals("Or")){
					
								foundEntries.add(fromCompare[0]+" "+fromCompare[1]+" From: "+fromCompare[2]+" To: "+toCompare[2]+" Key: "+fromCompare[3]/*+" tomKey: "+toCompare[3] */);
							}
							if(LogicC.equals("Not")){
								int q;
								for(q = 1; q <= foundEntries.size() - 1;q++){
								if(foundEntries.get(q).equals(fromCompare[0]+" "+fromCompare[1]+" From: "+fromCompare[2]+" To: "+toCompare[2]+" Key: "+fromCompare[3])){
									foundEntries.remove(q);}
								}
							}
						
								}  
					  }
					  	double  progress = 0;
						  if(i+1 != fromOrEntries.size()){
							  progress = (((i+1)*1.0/fromOrEntries.size())*100/4)+75; }else {progress = 100;}
						
						  setProgress((int)progress);
					  }
				  
				  
			  }
			  
			  setProgress(100);
			
		 }
		  resultOfSearch = new String[foundEntries.size()];
		 for(int i=0; i<foundEntries.size();i++){
			  resultOfSearch[i] = foundEntries.get(i);
			 
			  } 
		 }
		  
	  public void getData(String[] dvojbodkaSpliter,String[] dateSpliter,String from,String to,String LogicA){
		  Pattern pat = Pattern.compile("\\wx/\\w");
		  Matcher mat = pat.matcher(dvojbodkaSpliter[0]);
		  Pattern fromToPattern = Pattern.compile("=<|>");
		  
		  
		
		Pattern similarFrom = Pattern.compile(from);
		Pattern similarTo = Pattern.compile(to);
		
		while (mat.find()){
			  
			  
			  if(dvojbodkaSpliter.length == 4 ){
					String[] fromToSting = fromToPattern.split(dvojbodkaSpliter[2]);
				   
					 if(fromToSting[0].equals("to")){
						 if(LogicA.equals("Or")){
						 toOrEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );}
						 
						  if(toRequest == true){
							  Matcher SimilarIs = similarTo.matcher(fromToSting[1]);
							  if(SimilarIs.find()){
								  if(LogicA.equals("And")||LogicA.equals("Or")){
								  toEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );
								  }
								  }else{if(LogicA.equals("Not")){toEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );}}
						  }else{toEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );
						
						  }}}
			  
			    if(dvojbodkaSpliter.length == 3 ){
				  String[] fromToSting = fromToPattern.split(dvojbodkaSpliter[2]);
				
				  
				  if(fromToSting[0].equals("to")){
					  if(LogicA.equals("Or")){
							 toOrEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );}
					  if(toRequest == true){
						  Matcher SimilarIs = similarTo.matcher(fromToSting[1]);
						  if(SimilarIs.find()){
							  if(LogicA.equals("And")||LogicA.equals("Or")){
							  toEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );
							  }
							 }else{if(LogicA.equals("Not")){toEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );}}
					  }else{toEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );
					  
					  }}
					 
				  if(fromToSting[0].equals("from")){
					  if(LogicA.equals("Or")){
							 fromOrEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );}
				  if(fromRequest == true){
					
					
					Matcher SimilarIs = similarFrom.matcher(fromToSting[1]);
					
					  if(SimilarIs.find()/*from.equals(fromToSting[1])*/){
						  
						  fromEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );
						  
					  }
				  }else{  fromEntries.add(dateSpliter[0]+":"+dateSpliter[1]+":"+ fromToSting[1]+":"+dvojbodkaSpliter[1] );
				  
				  }}
				  }
			}
	 }
		 
		public String[] getResults(){
		
	 return resultOfSearch;}
		
		public String getInfo(String Key){
			Pattern keyExtractorPattern = Pattern.compile("\\.|@");
			Pattern pattern3 = Pattern.compile(": ");
			Pattern pat = Pattern.compile("\\wx/\\w");
			Pattern pat3 = Pattern.compile("opendkim.[0-9]{3}.");
			List<String> resultList = new ArrayList<String>();
			
			for(int i = 0; i<= myStrings.size() - 1 ; i++ ){
				
				Pattern serverName = Pattern.compile(" ");
				String[] serverGetter = serverName.split(myStrings.get(i));
				Pattern pattern2 = Pattern.compile(" "+serverGetter[3]+" " );
    	        //String[] serverSpliter = pattern2.split(myStrings.get(i));
				
				String[] serverSpliter = pattern2.split(myStrings.get(i));
				  String[] dvojbodkaSpliter = pattern3.split(serverSpliter[1]);
				  Matcher mat = pat.matcher(dvojbodkaSpliter[0]);
				//  Matcher mat2 = pat2.matcher(dvojbodkaSpliter[0]);
				  Matcher mat3 = pat3.matcher(dvojbodkaSpliter[0]);
				 // Matcher matExtra = patExtra.matcher(dvojbodkaSpliter[0]);
				  
				  while (mat.find()){
					
					    if(dvojbodkaSpliter.length == 3 ){
						  if(keyFinder(dvojbodkaSpliter[1], Key)){
							  String correcter = myStrings.get(i);
							  correcter = correcter.replace("<", "&lt")/*("<", "&lt")*/;
							  correcter = correcter.replace(">", "&gt");
						  resultList.add(correcter);
							
						  }
						  
							 String[] extractedKey = keyExtractorPattern.split(dvojbodkaSpliter[2]);
							 for(int k=0;k<=extractedKey.length-1;k++){
								 if(keyFinder(extractedKey[k], Key)){
									 String correcter = myStrings.get(i);
									 correcter = correcter.replace("<", "&lt");
									 correcter = correcter.replace(">", "&gt");
							  resultList.add(correcter);
									
								  }
							}}
					    if(dvojbodkaSpliter.length == 4 ){
					    	if(keyFinder(dvojbodkaSpliter[1], Key)){
					    		String correcter = myStrings.get(i);
					    		correcter = correcter.replace("<", "&lt");
					    		correcter = correcter.replace(">", "&gt");
						  resultList.add(correcter);
							
							  }
					    	if(keyFinder(dvojbodkaSpliter[3], Key)){
					    		String correcter = myStrings.get(i);
					    		correcter = correcter.replace("<", "&lt");
					    		correcter =	correcter.replace(">", "&gt");
						  resultList.add(correcter);
								
							  }}
				  }
				  
				  while (mat3.find()){
					
					 if(dvojbodkaSpliter.length == 3 ){
						 if(keyFinder(dvojbodkaSpliter[1], Key)){
							 String correcter = myStrings.get(i);
							 correcter = correcter.replace("<", "&lt");
							 correcter = correcter.replace(">", "&gt");
							  resultList.add(correcter);}
						 }}
				  	}
			
			String result = "<html>"+ String.join("<br/>", resultList) +"</html>";
			
			return  result;
		}

		public int monthToNumber(String month){
			switch(month){
			case "Jan": return 1;
			case "Feb": return 2;
			case "Mar": return 3;
			case "Apr": return 4;
			case "May": return 5;
			case "Jun": return 6;
			case "Jul": return 7;
			case "Aug": return 8;
			case "Sep": return 9;
			case "Oct": return 10;
			case "Nov": return 11;
			case "Dec": return 12;
			}
			return 0;
		}
		public String numberToMonth(int month){
			switch(month){
			case 1: return "Jan";
			case 2: return "Feb";
			case 3: return "Mar";
			case 4: return "Apr";
			case 5: return "May";
			case 6: return "Jun";
			case 7: return "Jul";
			case 8: return "Aug";
			case 9: return "Sep";
			case 10: return "Oct";
			case 11: return "Nov";
			case 12: return "Dec";
			}
			return "";
		}
		
		public String numberToString(int day){
			switch(day){
			case 1: return "01";
			case 2: return "02";
			case 3: return "03";
			case 4: return "04";
			case 5: return "05";
			case 6: return "06";
			case 7: return "07";
			case 8: return "08";
			case 9: return "09";
			} 
			
			return Integer.toString(day) ;
		}

		@Override
		protected Void doInBackground() throws Exception {
			
			proccessData();
			return null;
		}
		
		public boolean getTruth(){
			return truth;
		}
		
		@Override
        public void done() {
          truth=true;
        }
		
}
