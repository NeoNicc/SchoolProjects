public class Die {
    private int rolledNum = (int)(Math.random() * 6) + 1;

    public void setResult(int num) {
        this.rolledNum = num;
    }
    public int getResult() {
        return rolledNum;
    }
}
