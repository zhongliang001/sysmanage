const path = require('path')
const {CleanWebpackPlugin} = require('clean-webpack-plugin')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const VueLoaderPlugin = require('vue-loader/lib/plugin')

module.exports = {
  entry: {
    index: './src/index.js'
  },
  plugins: [
    new CleanWebpackPlugin(),
	new HtmlWebpackPlugin({
		filename:'index.html' ,
		template: path.join(__dirname, '../index.html'),
		favicon: path.resolve('./src/timg.jpg') ,
		title: 'bankweb'
	}),
	new VueLoaderPlugin()
  ],
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, '../dist')
  },
  module: {
  	rules: [{
  			test: /\.css$/,
  			use: [
  				'style-loader',
  				'css-loader'
  			]
  		},
  		{
  			test: /\.(png|svg|jpg|gif)$/,
  			use: [
  				'file-loader'
  			]
  		},
		{
			test: /\.vue$/,
			loader: 'vue-loader'
		},
		{
			test: /\.js$/,
			use: [{
				loader: 'babel-loader',
				options: {
					presets: ['es2015']
				}
			}],
			exclude: /node_modules/	
		}
  	]
  }
};