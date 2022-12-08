package chars;

import java.util.List;

public class Xbowman extends Base {
    public Xbowman(List<Base> gang, int x, int y) {
        super(6, 3, 16, new int[]{2,3}, 10, 10, 4, false, false, "Xbowman");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void Step(List<Base> group) {
        if(this.status.equals("dead")) return;

        for(Base npc: this.gang)
        {
            if(npc.getName().equals("Peasant") && npc.status.equals("stand"))
            {
                this.shoot++;
                npc.status = "used";
                break;
            }
        }
        if(this.shoot < 1) return;

        double minDistance = Double.MAX_VALUE;
        int nearestIndex = 0;
        for (int i = 0, j = 0; i < group.size(); i++)
        {
            if(!group.get(i).status.equals("dead"))
            {
                double temp = this.nearestDistance(group.get(i));
                if(minDistance > temp)
                {
                    minDistance = temp;
                    nearestIndex = i;
                }
            }else if(group.get(nearestIndex).status.equals("dead") && j < group.size() - 1){
                while(j < group.size() - 1)
                {
                    if(!group.get(j).status.equals("dead")) break;
                    else j++;
                }
                nearestIndex = j;
                j = 0;
            }
        }
        this.shoot--;

        Base defendingNpc = group.get(nearestIndex);
        double totalDamage = Damage(defendingNpc);

        if(minDistance > this.getSpeed()){totalDamage = totalDamage / 2;}

        defendingNpc.setCurrentHealth(defendingNpc.getCurrentHealth() - totalDamage);

        if(defendingNpc.getCurrentHealth() <= 0){
            defendingNpc.status = "dead";
        }
    }

    @Override
    public String GetInfo() {
        return "Xbowman - " +
                "Status(" + status + "), " +
                "HP(10.0 - " + getCurrentHealth() + ")";
    }
}
