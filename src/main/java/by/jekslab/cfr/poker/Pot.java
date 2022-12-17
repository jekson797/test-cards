package by.jekslab.cfr.poker;

import java.util.*;

public class Pot {

    private final Map<String, Double> pot = new HashMap<>();
    private final String uid = UUID.randomUUID().toString();

    public double getPlayerPotContribution(Player player) {
        return pot.get(player.getName());
    }

    public void addChips(Player player, double chipsAmount) {
        pot.merge(player.getName(), chipsAmount, Double::sum);
    }

    public void reset() {
        pot.clear();
    }

    public List<Map<String, Double>> computeSidePots() {
        List<Map<String, Double>> sidePots = new ArrayList<>(8);
        if (pot.isEmpty()) {
            return sidePots;
        }

        Map<String, Double> potDuplicate = new HashMap<>(pot);
        while (!potDuplicate.isEmpty()) {
            Map<String, Double> sidePot = new HashMap<>();
            double minChipsNumber = Collections.min(potDuplicate.values());
            Set<String> playersToRemove = new HashSet<>(4);

            for (Map.Entry<String, Double> contribution : potDuplicate.entrySet()) {
                String player = contribution.getKey();
                sidePot.put(player, minChipsNumber);
                potDuplicate.merge(player, minChipsNumber, (a, b) -> a - b);
                if (potDuplicate.get(player) == 0) {
                    playersToRemove.add(player);
                }
            }
            potDuplicate.keySet().removeAll(playersToRemove);
            sidePots.add(sidePot);
        }
        return sidePots;
    }

    public String getUid() {
        return uid;
    }

    public double getTotalPot() {
        return pot.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public String toString() {
        return "Pot = " + getTotalPot();
    }
}
