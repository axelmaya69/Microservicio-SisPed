-- Insertar pedidos
INSERT INTO pedido (cliente_id, fecha) VALUES (1, '2024-05-01');
INSERT INTO pedido (cliente_id, fecha) VALUES (2, '2024-05-02');
INSERT INTO pedido (cliente_id, fecha) VALUES (3, '2024-05-03');
INSERT INTO pedido (cliente_id, fecha) VALUES (4, '2024-05-04');
INSERT INTO pedido (cliente_id, fecha) VALUES (5, '2024-05-05');
INSERT INTO pedido (cliente_id, fecha) VALUES (1, '2024-05-06');
INSERT INTO pedido (cliente_id, fecha) VALUES (3, '2024-05-07');
INSERT INTO pedido (cliente_id, fecha) VALUES (2, '2024-05-08');
INSERT INTO pedido (cliente_id, fecha) VALUES (4, '2024-05-09');
INSERT INTO pedido (cliente_id, fecha) VALUES (5, '2024-05-10');

-- Insertar productos de los pedidos
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (101, 2, 10.0, 1);
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (102, 1, 20.0, 2);
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (103, 3, 15.5, 3);
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (104, 2, 9.0, 4);
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (105, 1, 40.0, 5);
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (106, 4, 12.5, 6);
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (107, 2, 18.0, 7);
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (108, 5, 5.0, 8);
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (109, 1, 30.0, 9);
INSERT INTO pedido_producto (id_producto, cantidad, precio_unitario, pedido_id) VALUES (110, 2, 25.0, 10);
