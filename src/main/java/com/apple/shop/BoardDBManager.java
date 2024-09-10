package com.apple.shop;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardDBManager extends JpaRepository<Board, Long> {

}
