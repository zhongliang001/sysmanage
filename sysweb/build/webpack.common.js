const path = require("path")
const { CleanWebpackPlugin } = require("clean-webpack-plugin")
const HtmlWebpackPlugin = require("html-webpack-plugin")
const VueLoaderPlugin = require("vue-loader/lib/plugin")

module.exports = {
  entry: {
    index: "./src/index.js"
  },
  plugins: [
    new CleanWebpackPlugin(),
    new HtmlWebpackPlugin({
      filename: "index.html",
      template: path.join(
        __dirname,
        "../index.html"
      ),
      favicon: path.resolve("./src/timg.jpg"),
      title: "sysweb"
    }),
    new VueLoaderPlugin()
  ],
  output: {
    filename: "[name].bundle.js",
    path: path.resolve(
      __dirname,
      "../dist"
    )
  },
  resolve: {
    extensions: [
      ".js",
      ".vue",
      ".json"
    ],
    alias: {
      "@": path.resolve("src")
    }

  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: [
          "style-loader",
          "css-loader",
          "sass-loader"
        ]
      },
      {
        test: /\.(png|svg|jpg|gif)$/,
        use: ["file-loader"]
      },
      {
        test: /\.vue$/,
        loader: "vue-loader"
      },
      {
        test: /\.js$/,
        use: [
          {
            loader: "babel-loader",
            options: {
              babelrc: false,
              presets: ["es2015"],
              plugins: ["syntax-dynamic-import"]
            }
          }
        ],
        exclude: /node_modules/
      },
      {
        test: /\.(ttf|eot|svg|woff|woff2)$/,
        use: "url-loader"
      },
      {
        test: /\.scss$/,
        use: [
          {
            loader: "style-loader"
          },
          {
            loader: "css-loader"
          },
          {
            loader: "sass-loader"
          }
        ]
      }
    ]
  }
}
