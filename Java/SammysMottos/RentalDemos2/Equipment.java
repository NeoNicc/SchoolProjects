public abstract class Equipment {
    protected int equipmentType = -1;
    protected String equipmentName;
    protected int equipmentFee;
    protected final static String[] equipmentNames = {"Personal Watercraftski", "Pontoon Boat", "Rowboat", "Canoe", "Kayak", "Beach Chair", "Umbrella", "Other..."};
    protected final int[] equipmentCosts = {50, 40, 15, 12, 10, 2, 1, 0};

    Equipment(String equipType) {
        for(int i = 0; i < equipmentNames.length; i++) {
            if (equipType.equals(equipmentNames[i])) {
                this.equipmentType = i;
                this.equipmentName = equipmentNames[i];
                this.equipmentFee = equipmentCosts[i];
            }
        }
        if (equipmentType == -1) {
            this.equipmentType = 7;
            this.equipmentName = equipmentNames[7];
            this.equipmentFee = equipmentCosts[7];
        }
    }

    public int getEquipmentType() {
        return equipmentType;
    }
    public void setEquipmentType(int type) {
        this.equipmentType = type;
    }

    public String getEquipmentName() {
        return equipmentName;
    }
    public void setEquipmentName(String name) {
        this.equipmentName = name;
    }

    public int getEquipmentFee() {
        return equipmentFee;
    }
    public void setEquipmentFee(int fee) {
        this.equipmentFee = fee;
    }

    public static String[] getEquipmentNames() {
        return equipmentNames;
    }
    public static String displayEquipmentNames() {
        String phrase = "";
        for(int i = 0; i < equipmentNames.length; i++) {
            phrase += equipmentNames[i];
            phrase += " ";
        }
        return phrase;
    }

    public abstract String lessonPolicy();
}
