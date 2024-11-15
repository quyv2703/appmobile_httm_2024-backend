from preprocess_data import data
# Kiểm tra một số văn bản đã được xử lý
for i in range(5):
    print(f"Original: {data['text'].iloc[i]}")
    print(f"Processed: {data['processed_text'].iloc[i]}")
