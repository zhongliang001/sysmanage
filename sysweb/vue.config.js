module.exports = {
  devServer: {
    host: '192.168.31.194',
    port: 80
  },
  pages: {
    index: {
      // page 的入口
      entry: './src/index.js',
      template: 'index.html',
      filename: 'index.html',
      title: '系统管理',
      favicon: './src/timg.jpg'
    }
  },
  productionSourceMap: false
}
