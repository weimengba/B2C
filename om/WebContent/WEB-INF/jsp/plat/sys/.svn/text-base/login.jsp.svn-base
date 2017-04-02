<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<jsp:include page="/layout/html_head.jsp"></jsp:include>
</head>
    <body class="login-page" style="background: url(assets/img/background.jpg) no-repeat;background-size:100%;">
        <!-- Start #login -->
        <div id="login" class="animated bounceIn">
            <img id="logo" src="assets/img/logo.png" alt="sprFlat Logo">
            <!-- Start .login-wrapper -->
            <div class="login-wrapper">
                <ul id="myTab" class="nav nav-tabs nav-justified bn">
                    <li>
                        <a href="#log-in" data-toggle="tab">登&nbsp;&nbsp;录</a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content bn">
                    <div class="tab-pane fade active in" id="log-in">
                        <div class="social-buttons text-center mt10">
                        </div>
                        <div class="seperator">
                            <strong>or</strong>
                            <hr>
                        </div>
                        <form class="form-horizontal mt10" action="plat/sys/login.do" id="login-form" role="form">
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="text" name="account" class="form-control left-icon"  placeholder="请输入用户名 ">
                                    <i class="ec-user s16 left-input-icon"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="password" name="password" id="password" class="form-control left-icon" placeholder="请输入密码">
                                    <i class="ec-locked s16 left-input-icon"></i>
                                    <span class="help-block"><a href="#"><small>忘记密码 ?</small></a></span> 
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-8">
                                    <!-- col-lg-12 start here -->
                                    <label class="checkbox">
                                        <input type="checkbox" name="remember" id="remember" value="option">记住我 ?
                                    </label>
                                </div>
                                <!-- col-lg-12 end here -->
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-4">
                                    <!-- col-lg-12 start here -->
                                    <button class="btn btn-success pull-right" type="submit">登录</button>
                                </div>
                                <!-- col-lg-12 end here -->
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="register">
                        <form class="form-horizontal mt20" action="#" id="register-form" role="form">
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <!-- col-lg-12 start here -->
                                    <input id="email1" name="email" type="email" class="form-control left-icon" placeholder="Type your email">
                                    <i class="ec-mail s16 left-input-icon"></i> 
                                </div>
                                <!-- col-lg-12 end here -->
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <!-- col-lg-12 start here -->
                                    <input type="password" class="form-control left-icon" id="password1" name="password" placeholder="Enter your password">
                                    <i class="ec-locked s16 left-input-icon"></i> 
                                </div>
                                <!-- col-lg-12 end here -->
                                <div class="col-lg-12 mt15">
                                    <!-- col-lg-12 start here -->
                                    <input type="password" class="form-control left-icon" id="confirm_password" name="confirm_passowrd" placeholder="Repeat password">
                                    <i class="ec-locked s16 left-input-icon"></i> 
                                </div>
                                <!-- col-lg-12 end here -->
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <!-- col-lg-12 start here -->
                                    <button class="btn btn-success btn-block">Register</button>
                                </div>
                                <!-- col-lg-12 end here -->
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- End #.login-wrapper -->
        </div>
        <!-- End #login -->
        <!-- Javascripts -->
        <!-- Load pace first -->
        <script src="assets/plugins/core/pace/pace.min.js"></script>
        <!-- Important javascript libs(put in all pages) -->
        <script src="assets/js/jquery-1.8.3.min.js"></script>
        <script>
        window.jQuery || document.write('<script src="assets/js/libs/jquery-2.1.1.min.js">\x3C/script>')
        </script>
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <script>
        window.jQuery || document.write('<script src="assets/js/libs/jquery-ui-1.10.4.min.js">\x3C/script>')
        </script>
        <!--[if lt IE 9]>
  <script type="text/javascript" src="assets/js/libs/excanvas.min.js"></script>
  <script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <script type="text/javascript" src="assets/js/libs/respond.min.js"></script>
<![endif]-->
        <!-- Bootstrap plugins -->
        <script src="assets/js/bootstrap/bootstrap.js"></script>
        <!-- Form plugins -->
        <script src="assets/plugins/forms/icheck/jquery.icheck.js"></script>
        <script src="assets/plugins/forms/validation/jquery.validate.js"></script>
        <script src="assets/plugins/forms/validation/additional-methods.min.js"></script>
        <!-- Init plugins olny for this page -->
        <script src="assets/js/pages/login.js"></script>
        
    </body>
</html>