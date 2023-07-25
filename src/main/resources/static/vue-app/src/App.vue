<template>
  <div id="app">
    <!-- Your other app content -->
    <CategorySelect v-model="selectedCategory" />
  </div>
</template>

<script>
import CategorySelect from './components/CategorySelect.vue';

export default {
  name: 'App',
  components: {
    CategorySelect,
  },
  data() {
    return {
      selectedCategory: 'default',
    };
  },
};
</script>

<style>
/* Your styles */
</style>