let common = {
        getForm: function(obj,ref) {
            let _this = obj;
            if (!_this) {
                alert('对象不存在')
            }else{
                return _this.$refs[ref]
            }
        }
}
export default common
