<template>
  <router-view />
</template>

<script>

export default {
  name: 'App',
  head: {
    script: [
      {
        type: "text/javascript",
        src: "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js",
      },
      {
        type: "text/javascript",
        src:
          "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js",
      },
      {
        type: "text/javascript",
        src:
          "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js",
      },
    ],
  }
}
</script>

<style>
@import url(https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css);
@import url(https://use.fontawesome.com/releases/v5.7.0/css/all.css);
@import url('./assets/css/home.css');
</style>
