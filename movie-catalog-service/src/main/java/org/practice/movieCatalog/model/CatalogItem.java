package org.practice.movieCatalog.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItem {
    private String Name;
    private String Description;
    private int rating;
}
