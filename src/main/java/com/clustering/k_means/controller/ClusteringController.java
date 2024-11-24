package com.clustering.k_means.controller;

import com.clustering.k_means.services.ClusteringService;
import com.clustering.k_means.services.measures.Measure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/kmeans/clustering")
public class ClusteringController {

    private final ClusteringService clusteringService;

    @GetMapping("/do-clustering")
    public ResponseEntity<List<Map<String,Object>>> doClustering(
            @RequestParam("clusters") Integer cluster,
            @RequestParam("measure") Measure measure ) {
        return ResponseEntity.ok(clusteringService.clusteredData(cluster, measure));
    }
}
