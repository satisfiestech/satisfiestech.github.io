document.addEventListener("DOMContentLoaded", function () {
  fetch("/api/products")
    .then(response => response.json())
    .then(data => {
      const list = document.getElementById("product-list");
      data.forEach(product => {
        const item = document.createElement("li");
        item.innerHTML = `${product.name} - ₹${product.price}`;
        list.appendChild(item);
      });
    })
    .catch(error => console.error("Error fetching products:", error));
});
