<template>
  <h6>
    <div class="centered-container">
      <div class="dropdown-header">
        <select v-model="selectedCategory" id="product_category">
          <option value="default">Select a product category</option>
          <option v-for="category in categories" :value="category.categoryName" :key="category.id">
            {{ category.categoryName }}
          </option>
        </select>
      </div>
    </div>
  </h6>
</template>

<script setup>

import { ref, onMounted } from 'vue';
const selectedCategory = ref('default');
const categories = ref([]);
onMounted(async () => {
  try {
    const response = await fetch("http://localhost:8080/api/categories");
    if (!response.ok) {
      throw new Error("Failed to fetch categories.");
    }
    categories.value = await response.json();
  } catch (error) {
    console.error("Error fetching categories:", error);
  }
});
</script>
