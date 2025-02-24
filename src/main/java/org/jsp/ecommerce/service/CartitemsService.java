package org.jsp.ecommerce.service;

import org.springframework.http.ResponseEntity;

public interface CartitemsService {

	ResponseEntity<?> saveCartitem(int cid, int pid);

	ResponseEntity<?> changingQuantity(int cid, int quan);

}
