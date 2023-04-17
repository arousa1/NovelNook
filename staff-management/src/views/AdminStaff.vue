<template>
    <div>
        <el-container>
            <!-- <el-header>
                导航栏
            </el-header> -->
            <el-main>
                <!--搜索表单-->
                <el-form :inline="true" :model="searchStaff.username">
                    <el-form-item label="username">
                        <el-input v-model="searchStaff.username" placeholder="Please input the username"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="selectByuserName(searchStaff.username)">Search</el-button>
                        <el-button type="info" @click="clear">Clear</el-button>
                    </el-form-item>
                </el-form>

                <br>

                <!--表格-->
                <template>
                    <el-table :data="tableData" style="width: 100%" border>
                        <el-table-column prop="image" label="Avatar" align="center">
                            <template slot-scope="{ row }">
                                <el-image style="width: auto; height: 40px; border: none; cursor: pointer"
                                    :src="row.image"></el-image>
                            </template>
                        </el-table-column>
                        <el-table-column prop="firstname" label="FirstName" align="center"></el-table-column>
                        <el-table-column prop="lastname" label="LastName" align="center"></el-table-column>
                        <!-- <el-table-column  label="FullName" align="center">{{ scope.row.firstName }} + {{ scope.row.lastName }}</el-table-column> -->


                        <el-table-column align="center" label="Operation">
                            <template slot-scope="scope">
                                <el-button type="primary" size="small" @click="handleEdit(scope.$index, scope.row)">Look
                                    More</el-button>
                                <el-dialog title="Detailed Information" :visible.sync="dialogFormVisible">
                                    <el-form :model="form">
                                        <el-form-item label="Avatar" :label-width="formLabelWidth">
                                            <el-input v-model="form.Avatar" auto-complete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="firstName" :label-width="formLabelWidth">
                                            <el-input v-model="form.firstName" auto-complete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="lastName" :label-width="formLabelWidth">
                                            <el-input v-model="form.lastName" auto-complete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="userName" :label-width="formLabelWidth">
                                            <el-input v-model="form.userName" auto-complete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="password" :label-width="formLabelWidth">
                                            <el-input v-model="form.passWord" auto-complete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="telephone" :label-width="formLabelWidth">
                                            <el-input v-model="form.telephone" auto-complete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="email" :label-width="formLabelWidth">
                                            <el-input v-model="form.email" auto-complete="off"></el-input>
                                        </el-form-item>

                                    </el-form>
                                    <div slot="footer" class="dialog-footer">
                                        <el-button @click="dialogFormVisible = false">Quit</el-button>
                                        <el-button type="primary"
                                            @click="handleSet(scope.$index, scope.row)">Save</el-button>
                                    </div>
                                </el-dialog>
                                <el-button type="danger" size="small"
                                    @click="bandDeleteName(scope.row)">Delete</el-button>
                                <el-dialog title="提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
                                    <span>Do you confirm to delete this staff?</span>
                                    <span slot="footer" class="dialog-footer">
                                        <el-button @click="dialogVisible = false">Quit</el-button>
                                        <el-button type="primary" @click="deleteByuserName()" >Confirm</el-button>
                                    </span>
                                </el-dialog>
                            </template>
                        </el-table-column>
                    </el-table>
                </template>

                <!--分页工具条-->
                <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                    :background="background" :current-page="currentPage" :page-sizes="[10, 20, 30, 40]" :page-size="10"
                    layout="total, sizes, prev, pager, next, jumper" :total="totalCount">
                </el-pagination>

            </el-main>

        </el-container>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    inject: ["reload"],
    name: 'admin-staff',
    data() {
        return {
            dialogTableVisible: false,
            dialogFormVisible: false, // 详情表单
            dialogVisible: false,   // 删除对话框
            formLabelWidth: '120px',
            pageSize: 10, // 每页显示10条
            totalCount: 100, // 总记录数初始化为100
            currentPage: 1, // 当前页码
            tableData: [], // 接收返回的数据
            deleteName: "", // 删除的username名称
            form: { // 用来显示详情数据和更新数据
                Avatar: "",
                userName: "",
                passWord: "",
                firstName: "",
                lastName: "",
                telephone: "",
                email: ""
            },
            searchStaff: { // 接收输入的username
                username: ""
            },
            staff: {
                image: ""
            }
        }
    },
    created() { // 页面挂载完毕，请求全部数据
        let that = this;
        axios.get("http://localhost:8080/admin/staff")
            .then(function (resp) {
                if(resp.data.code === 1){
                    that.tableData = resp.data.data;
                }else{
                    alert(resp.data.msg);
                }
                
            })
    },
    methods: {
        selectByuserName(userName) {
            let that = this;
            axios.get("http://localhost:8080/admin/staff/" + userName).then(function (resp) {
                if(resp.data.code === 1){
                    that.tableData = resp.data.data;
                }else{
                    alert(resp.data.msg);
                }
            })
        },
        deleteByuserName() {
            this.dialogVisible = false;
            let that = this;
            console.log(that.deleteName);
            axios.delete("http://localhost:8080/admin/staff/" + that.deleteName)
                .then(function (resp) {
                    if(resp.data.code === 1){
                        that.tableData = resp.data.data;
                        that.reload();
                    }else{
                        alert(resp.data.msg);
                    }
                    
                    // that.tableData = resp.data;
                    // that.reload();
                })
        },
        clear() {
            this.searchStaff.username = ''
        },
        handleEdit(index, row) {
            this.dialogFormVisible = true
            this.form.Avatar = row.avatar
            this.form.firstName = row.firstname
            this.form.lastName = row.lastname
            this.form.userName = row.username
            this.form.passWord = row.password
            this.form.email = row.email
            this.form.telephone = row.telephone
        },
        bandDeleteName(row) {
            this.dialogVisible = true;
            this.deleteName = row.username;
        }
        // handleSet (index, row) {
        //     var params = {
        //         Avatar: this.form.Avatar,
        //         userName: this.form.userName,
        //         passWord: this.form.passWord,
        //         firstName: this.form.firstName,
        //         lastName: this.form.lastName,
        //         telephone: this.form.telephone,
        //         email: this.form.email
        //     }

        // }
    },

}
</script>


<style></style>