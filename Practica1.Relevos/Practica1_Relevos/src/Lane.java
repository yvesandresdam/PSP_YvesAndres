public class Lane {
    private int position;
    privte int idCarril;

    public Lane(int IDCarril){
        idCarril = IDCarril;
    }

    private boolean addRunner(Runner runner, int position){
        if(runner == null)
            return false;
        setPosition(runner, position);
        return true;
    }
    private boolean moveRunner(int idRunner){
        int nextPosition = position++;
        setPosition(idRunner, nextPosition);
        return true;
    }
    private boolean canGiveStick()
    {
        if(runner in next position)
            return true;
        return false;
    }


    // Getters and Setters
    public void setPosition(Runner runner, int position){
        this.position = position;
    }
    public int getPosition(int idRunner){
        return position;
    }
}
