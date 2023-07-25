import { createApp } from 'vue';
import App from './App.vue';
import CategorySelect from './components/CategorySelect.vue';

const app = createApp(App);
app.component('CategorySelect', CategorySelect);

app.mount('#app');
