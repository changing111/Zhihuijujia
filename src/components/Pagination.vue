<template>
    <div id="pagination" class="block">
        <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage"
        :page-sizes="[5, 10, 15, 20]"
        background
        layout="total,sizes, prev, pager, next,jumper"
        :total=this.total>
        </el-pagination>
    </div>
</template>
<script>
    export default {
        methods:{
            handleSizeChange(val) {
                this.$emit("SizeChange",val);
            },
            handleCurrentChange(val) {
                this.$emit("CurrentChange",val);
            }
        },
        data() {
            return {
                currentPage:1,
                pageSize:1,
            }
        },
        props:["total","currentPage"],
    }
</script>