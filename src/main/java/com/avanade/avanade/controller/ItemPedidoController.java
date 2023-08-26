package com.avanade.avanade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.avanade.avanade.dto.ItemPedidoDTO;
import com.avanade.avanade.service.ItemPedidoService;

public class ItemPedidoController {
     private ItemPedidoService service;
    public ItemPedidoController(ItemPedidoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public /* ResponseEntity<String> */ ItemPedidoDTO create(@RequestBody ItemPedidoDTO body) {
/*         return ResponseEntity.status(HttpStatus.CREATED).body("created " + body); */
        return service.create(body);
    }

    @GetMapping("/{id}")
    public ItemPedidoDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping("filter")
    public List<ItemPedidoDTO> getAll(
        @RequestBody ItemPedidoDTO body) {
        return service.getAll(body);
    }

    @PutMapping("/{id}")
    public ItemPedidoDTO edit(@RequestBody ItemPedidoDTO body, @PathVariable Long id) {
        return service.edit(body, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
