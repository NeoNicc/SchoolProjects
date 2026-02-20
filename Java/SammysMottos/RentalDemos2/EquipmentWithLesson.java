public class EquipmentWithLesson extends Equipment {
    private final int lessonCost = 27;

    EquipmentWithLesson(String equipType) {
        super(equipType);
        for (int i = 0; i < (equipmentNames.length - 3); i++) {
            if(equipType.equals(equipmentNames[i])) {
                this.equipmentType = i;
                this.equipmentName = equipmentNames[i];
                this.equipmentFee = equipmentCosts[i] + lessonCost;
            }
        }
        if (equipmentType == -1) {
            this.equipmentType = 7;
            this.equipmentName = equipmentNames[7];
            this.equipmentFee = equipmentCosts[7];
        }
    }

    public int getLessonCost() {
        return lessonCost;
    }

    public String lessonPolicy() {
        String phrase = "Our policy is to require a lesson for the first use of the " + equipmentName + ". There is a $" + lessonCost + " fee for a lesson.";
        return phrase;
    }
}
