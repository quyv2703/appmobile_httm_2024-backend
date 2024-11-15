import re
import pandas as pd
import numpy as np
from pyvi import ViTokenizer
from sklearn.pipeline import Pipeline
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.model_selection import train_test_split
from sklearn import metrics
import joblib

# Đọc danh sách stopwords từ file
with open('stopwords.txt', 'r', encoding='utf-8') as file:
    stop_words = set(line.strip() for line in file)

def preprocess_text(text):
    # Loại bỏ dấu câu và ký tự đặc biệt
    text = re.sub(r'[^\w\s]', '', text)
    # Chuyển văn bản về chữ thường
    text = text.lower()
    # Tách từ bằng ViTokenizer
    text = ViTokenizer.tokenize(text)
    # Loại bỏ stopwords
    text = ' '.join([word for word in text.split() if word not in stop_words])
    return text

def load_data(file_path):
    # Đọc dữ liệu từ file và bỏ qua dòng lỗi
    data = pd.read_csv(file_path, sep='\t', header=None, names=['text', 'label'], encoding='utf-8', on_bad_lines='skip')
    # Thay thế NaN bằng chuỗi rỗng
    data['text'] = data['text'].replace(np.nan, '', regex=True)
    # Tiền xử lý văn bản
    data['processed_text'] = data['text'].apply(preprocess_text)
    return data[['processed_text', 'label']]

# Đọc và tiền xử lý dữ liệu
data = load_data("C:/Users/Legion 5/Desktop/btml/data.txt")

# Chia dữ liệu thành tập huấn luyện và kiểm tra
X_train, X_test, y_train, y_test = train_test_split(
    data['processed_text'], data['label'], test_size=0.2, random_state=42
)

# Loại bỏ các giá trị trống trong X_train và y_train để đồng bộ kích thước
X_train = X_train[X_train != '']
y_train = y_train[X_train.index]  # Đồng bộ y_train với X_train

X_test = X_test[X_test != '']
y_test = y_test[X_test.index]  # Đồng bộ y_test với X_test

# Xuất dữ liệu huấn luyện ra file train.txt
train_data = pd.DataFrame({'text': X_train, 'label': y_train})
train_data.to_csv('train.txt', sep='\t', index=False, header=False)

# Xuất dữ liệu kiểm tra ra file test.txt
test_data = pd.DataFrame({'text': X_test, 'label': y_test})
test_data.to_csv('test.txt', sep='\t', index=False, header=False)

print("Dữ liệu huấn luyện và kiểm tra đã được xuất ra train.txt và test.txt!")

# Kiểm tra kích thước tập dữ liệu
print(f"Kích thước X_train: {len(X_train)}, y_train: {len(y_train)}")
print(f"Kích thước X_test: {len(X_test)}, y_test: {len(y_test)}")

# Xây dựng pipeline với TfidfVectorizer và Naive Bayes
pipeline = Pipeline([
    ('vect', TfidfVectorizer(ngram_range=(1, 2), max_df=0.95, min_df=2)),
    ('clf', MultinomialNB())
])

# Huấn luyện mô hình
pipeline.fit(X_train, y_train)

# Dự đoán và đánh giá
y_pred = pipeline.predict(X_test)
print(metrics.classification_report(y_test, y_pred))

# Lưu mô hình
joblib.dump(pipeline, 'sentiment_model.pkl')

print("Huấn luyện và lưu mô hình thành công!")
