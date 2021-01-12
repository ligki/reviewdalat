<template>
    <div>
        <Header />
        <div class="container">
            <News />
            <div class="home-main row">
                <div class="col-sm-8 border border-primary">
                    <ReviewElement type="place" />
                    <ReviewElement type="coffee-shop" />
                    <ReviewElement type="hotel" />
                    <ReviewElement type="food" />
                </div>
                <SideBar />
            </div>
        </div>
        <Footer />
        
    </div>

</template>

<script>
import Header from './common/Header.vue';
import News from './News.vue';
import ReviewElement from './ReviewElement.vue';
import SideBar from './SideBar';
import Footer from './common/Footer';

export default {
    name : "InstructorsApp",
    components: {
        Header,
        News,
        ReviewElement,
        SideBar,
        Footer
    }
}
</script>

<style scoped>

</style>