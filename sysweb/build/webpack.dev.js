const {merge} = require('webpack-merge');
const common = require('./webpack.common.js');

module.exports = merge(common, {
  devtool: 'inline-source-map',
  devServer: {
    disableHostCheck: true,
    host:'localhost',
    port:'80',
    contentBase: '../dist'
  }
});