const { merge } = require("webpack-merge")
const common = require("./webpack.common.js")

module.exports = merge(
  common,
  {
    devtool: "inline-source-map",
    devServer: {
      host: "127.0.0.1",
      port: "80",
      static: false
    }
  }
)
