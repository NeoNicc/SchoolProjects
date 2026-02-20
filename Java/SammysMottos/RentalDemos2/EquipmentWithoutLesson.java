public class EquipmentWithoutLesson extends Equipment {
    EquipmentWithoutLesson(String equipType) {
        super(equipType);
        for (int i = 5; i < (equipmentNames.length); i++) {
            if(equipType.equals(equipmentNames[i])) {
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

    public String lessonPolicy() {
        String phrase = "Our policy is not to require a lesson for the first use of the " + equipmentName + ".";
        return phrase;
    }
}
