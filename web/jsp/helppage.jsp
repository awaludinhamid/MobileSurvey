<%-- 
    Document   : helppage
    Created on : Oct 4, 2016, 7:39:15 PM
    Author     : awal
--%>

<%@include file="support/header.jsp" %>
<%@include file="support/top-menu.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <!--link rel="stylesheet" href="../../css/help.css"/-->
  </head>
  <body>
    <div class="container body-style-topmenu">
      <div class="row">
        <div class="panel panel-info">
          <div class="panel-heading">
            <h4 class="panel-title">General</h4>
          </div>
          <div class="panel-body">
            <ul>
              <li>Setiap modul aplikasi pada dasarnya berupa tabel yang bisa dimodifikasi ataupun ditampilkan</li>
              <li>Modifikasi tabel bisa berupa penambahan data, perubahan data, dan penghapusan data</li>
              <li>Setiap modifikasi tabel membutuhkan konfirmasi agar tersimpan permanen</li>
              <li>Gunakan tombol <i>add</i> untuk menambah data:
                <ul>
                  <li>Perhatikan kolom-kolom <i>mandatory</i> yang wajib diisi datanya</li>
                  <li>Sesuaikan pengisian kolom dengan tipe datanya</li>
                </ul>
              </li>
              <li>Gunakan tombol <i>update</i> untuk mengubah data, perhatikan bahwa hanya data terakhir yang akan tersimpan</li>
              <li>Gunakan tombol <i>delete</i> untuk menghapus data, perhatikan bahwa setelah terhapus data hilang permanen dari tabel</li>
              <li>Gunakan tombol <i>view</i> untuk menampilkan data yang sudah tersedia di tabel</li>
              <li>Gunakan tombol <i>search</i> untuk pencarian data tertentu</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
