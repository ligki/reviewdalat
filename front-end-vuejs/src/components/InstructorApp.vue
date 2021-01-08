<template>
    <div>
        <Header />
        <div class="container">
            <News />
            <div class="home-main row">
                <div class="col-sm-8 border border-primary">
                    
                </div>
            </div>
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