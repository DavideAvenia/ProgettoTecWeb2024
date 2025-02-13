package com.uniparthenope.innervision.util;

import com.uniparthenope.innervision.entity.Acquisto;
import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.diz.DizMarchio;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationUtil {

    private Map<Long, Set<DizMarchio>> userBrands = new HashMap<>();

    public Map<Long, List<DizMarchio>> generateRecommendations(List<Acquisto> acquisti) {
        userBrands.clear();
        for (Acquisto acquisto : acquisti) {
            userBrands.computeIfAbsent(acquisto.getUtente().getIdUtente(),
                    k -> new HashSet<>()).add(acquisto.getMarchio());
        }

        Map<Long, List<DizMarchio>> recommendations = new HashMap<>();

        for (Long idUtente : userBrands.keySet()) {
            List<DizMarchio> recommendedBrands = recommendBrands(idUtente, userBrands);
            recommendations.put(idUtente, recommendedBrands);
        }

        return recommendations;
    }

    public List<DizMarchio> recommendBrands(Long userId, Map<Long, Set<DizMarchio>> userBrands) {
        Set<DizMarchio> purchasedBrands = userBrands.get(userId);
        Map<DizMarchio, Integer> brandCount = new HashMap<>();

        for (Map.Entry<Long, Set<DizMarchio>> entry : userBrands.entrySet()) {
            if (!entry.getKey().equals(userId)) {
                for (DizMarchio brand : entry.getValue()) {
                    if (!purchasedBrands.contains(brand)) {
                        brandCount.put(brand, brandCount.getOrDefault(brand, 0) + 1);
                    }
                }
            }
        }

        List<Map.Entry<DizMarchio, Integer>> sortedBrands = new ArrayList<>(brandCount.entrySet());
        sortedBrands.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<DizMarchio> recommendations = new ArrayList<>();
        for (Map.Entry<DizMarchio, Integer> entry : sortedBrands) {
            recommendations.add(entry.getKey());
        }

        return recommendations.size() > 2 ? recommendations.subList(0, 2) : recommendations;
    }

    public Map<Long, List<Articolo>> generateRecommendationsWithArticles(List<Acquisto> acquisti, List<Articolo> articoli) {
        Map<Long, List<Articolo>> userRecommendedArticles = new HashMap<>();
        Map<Long, List<DizMarchio>> userBrandRecommendations = generateRecommendations(acquisti);

        for (Long userId : userBrandRecommendations.keySet()) {
            List<DizMarchio> recommendedBrands = userBrandRecommendations.get(userId);
            Set<DizMarchio> purchasedBrands = userBrands.get(userId);
            List<Articolo> recommendedArticles = new ArrayList<>();
            List<Articolo> otherArticles = new ArrayList<>();

            Set<Articolo> addedArticles = new HashSet<>();

            for (Articolo articolo : articoli) {
                if (recommendedBrands.contains(articolo.getMarchio())) {
                    if (addedArticles.add(articolo)) {
                        recommendedArticles.add(articolo);
                    }
                } else if (purchasedBrands.contains(articolo.getMarchio())) {
                    if (addedArticles.add(articolo)) {
                        recommendedArticles.add(0, articolo);
                    }
                } else {
                    if (addedArticles.add(articolo)) {
                        otherArticles.add(articolo);
                    }
                }
            }

            recommendedArticles.addAll(otherArticles);
            userRecommendedArticles.put(userId, recommendedArticles.stream().distinct().collect(Collectors.toList()));
        }

        return userRecommendedArticles;
    }
}
