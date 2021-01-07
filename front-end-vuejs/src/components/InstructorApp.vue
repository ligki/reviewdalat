<template>
    <div>
        <Header />
        <div class="container">
            <News />
        </div>
    </div>

</template>

<script>
import Header from './common/Header.vue';
import News from './News.vue';
export default {
    name : "InstructorsApp",
    components: {
        Header,
        News
    }
}
</script>

<style scoped>

</style>