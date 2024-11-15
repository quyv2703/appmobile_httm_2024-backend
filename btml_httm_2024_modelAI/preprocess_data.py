import re
import pandas as pd
import numpy as np
from pyvi import ViTokenizer

# Đọc danh sách stopwords từ file
with open('stopwords.txt', 'r', encoding='utf-8') as file:
    stop_words = set(line.strip() for line in file)

def preprocess_text(text):
    # Loại bỏ dấu câu và ký tự đặc biệt
    text = re.sub(r'[^\w\s]', '', text)
    
    # Chuyển đổi văn bản về chữ thường
    text = text.lower()
    
    # Tách từ bằng ViTokenizer
    text = ViTokenizer.tokenize(text)
    
    # Loại bỏ stopwords
    text = ' '.join([word for word in text.split() if word not in stop_words])
    
    return text

def load_data(file_path):
    # Đọc dữ liệu từ file TXT
    data = pd.read_csv(file_path, sep='\t', header=None, names=['text', 'label'], encoding='utf-8', on_bad_lines='skip')
    return data

# Đọc dữ liệu từ file
data = load_data("C:/Users/Legion 5/Desktop/btml/data.txt")

# Thay thế NaN bằng chuỗi rỗng
#data['text'] = data['text'].replace(np.nan, '', regex=True)

# Hoặc loại bỏ các hàng có NaN trong cột 'text'
data = data.dropna(subset=['text'])

# Áp dụng tiền xử lý cho cột văn bản
data['processed_text'] = data['text'].apply(preprocess_text)

# Lưu dữ liệu đã tiền xử lý vào file CSV mới
data[['processed_text', 'label']].to_csv("processed_data.csv", index=False)

print("Tiền xử lý hoàn tất và dữ liệu đã được lưu vào 'processed_data.csv'.")
