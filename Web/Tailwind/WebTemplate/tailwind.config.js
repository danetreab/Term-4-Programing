module.exports = {
  content: ["./dist/index.html"],
  theme: {
    extend: {
      fontFamily:{
        Poppin : ["Poppins", "sans-serif"],
        Spotify : ["Spotify","sans-serif"],
        SpotifyBold : ["SpotifyBold","sans-serif"],
      },
      colors:{
        'primary': '#1ed760',
        'first' : 'rgb(108, 14, 224)',
        'second': 'rgb(240, 55, 166)',
      },
      backgroundImage:{
        'hero-pattern':"url('https://www.scdn.co/i/free/bubbles-dktp.svg')"
      }
    },
  },
  plugins: [],
}
