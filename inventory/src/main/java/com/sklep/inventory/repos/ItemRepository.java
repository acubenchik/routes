package com.sklep.inventory.repos;

import com.sklep.inventory.model.AbstractRoute;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<AbstractRoute, Long> {
}
