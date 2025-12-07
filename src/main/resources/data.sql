-- Insert Products (only if table is empty)
INSERT INTO product (name, description, price, stock, image_url) 
SELECT 'Premium Headphones', 'High-quality wireless headphones with noise cancellation', 199.99, 50, 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'Premium Headphones');

INSERT INTO product (name, description, price, stock, image_url) 
SELECT 'Smart Watch', 'Feature-rich smartwatch with health monitoring', 299.99, 30, 'https://images.unsplash.com/photo-1523275335684-37898b6baf30'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'Smart Watch');

INSERT INTO product (name, description, price, stock, image_url) 
SELECT 'Wireless Speaker', 'Portable Bluetooth speaker with premium sound quality', 89.99, 100, 'https://images.unsplash.com/photo-1608043152269-423dbba4e7e1'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'Wireless Speaker');

INSERT INTO product (name, description, price, stock, image_url) 
SELECT 'Gaming Mouse', 'Precision gaming mouse with customizable RGB lighting', 79.99, 75, 'https://images.unsplash.com/photo-1527814050087-3793815479db'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'Gaming Mouse');

INSERT INTO product (name, description, price, stock, image_url) 
SELECT 'Mechanical Keyboard', 'RGB mechanical keyboard with Cherry MX switches', 149.99, 40, 'https://images.unsplash.com/photo-1587829741301-dc798b83add3'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'Mechanical Keyboard');

INSERT INTO product (name, description, price, stock, image_url) 
SELECT 'USB-C Hub', '7-in-1 USB-C hub with HDMI and card reader', 49.99, 120, 'https://images.unsplash.com/photo-1625948515291-69613efd103f'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'USB-C Hub');