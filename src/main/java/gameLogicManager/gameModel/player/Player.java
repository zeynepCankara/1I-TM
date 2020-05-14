package gameLogicManager.gameModel.player;

public class Player {
    private String name;
    private Faction faction;
    private int shipping;
    private int spadeRate;
    private int numOfWorkers;
    //private RemainedStructure remainedStructure;


    public Faction getFaction() {
        return faction;
    }
    public int getNumOfWorkers(){return numOfWorkers;}
    public void setNumOfWorkers(int numOfWorkers){this.numOfWorkers = numOfWorkers;}
    public int getSpadeRate(){return spadeRate;}
    public int getShipping() { return shipping; }
}
