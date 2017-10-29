package DAL;

public class AccessPlayers  extends DatabaseService  {

    public AccessPlayers() {
        super("../data/FPlayers.txt");

    }
}

/*	public boolean checkData(String UserID){		//Check for injuries (STATE)???
		
		List<String> cus = getData();
		for (int i = 0; i < cus.size(); i++) {
			String[] detail = cus.get(i).split(",");
			if (Integer.parseInt(detail[0]) == Integer.parseInt(UserID)) {
				return true;
			}
		}
		return false;
	}
	
   @Override
    public void changeData(int id) {
        List<String> fileData = super.getData();

        for(int i = 1; i < fileData.size(); i++){
            String[] detail = fileData.get(i).split(",");
            if(Integer.parseInt(detail[0]) == id && detail[6].equalsIgnoreCase("ACCEPTED")){
                detail[6] = "PACKING";
                fileData.set(i,parseIntoString(detail));
            }
        }
        super.writeData(fileData);
    }

    public String parseIntoString(String[] order){
        String temp = "";
        for(int i = 0; i < order.length; ++i){
            if(i ==0)
                temp += order[i];
            else
                temp += "," + order[i];
        }
            return temp;
    }
*/