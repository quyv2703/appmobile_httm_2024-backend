from flask import Flask, render_template, redirect, url_for, jsonify
import requests

app = Flask(__name__)

# Trang chủ quản lý
@app.route('/')
def home():
    return render_template('home.html')

# Trang danh sách thông tin đặt lịch
@app.route('/danh_sach_dat_lich')
def danh_sach_dat_lich():
    # Gọi API lấy dữ liệu
    api_url = 'http://localhost:8080/btml/api/thongtindatlich'
    response = requests.get(api_url)
    data = response.json()
    return render_template('thongtindatlich.html', data=data)

if __name__ == '__main__':
    app.run(debug=True)
