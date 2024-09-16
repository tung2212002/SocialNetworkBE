package com.tungong.socialnetwork.application.port.output.post;

import com.tungong.socialnetwork.domain.model.post.Post;
import com.tungong.socialnetwork.domain.model.post.PostTagUser;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;

import java.util.List;

public interface PostPort {
  enum TAKE_POST_STATUS {
    PUBLIC,
    FRIEND,
    PRIVATE,
    ALL
  }

  List<Post> getListSuggest(Long userId, PaginationRequest paginationRequest);

  Post save(Post post);

  Post getById(Long id);

  List<Post> getListByUserIdAndFriendStatus(Long userId, TAKE_POST_STATUS status, List<Long> blockIds, PaginationRequest paginationRequest);

  Boolean deleteById(Long id);

  List<Post> getListInteractions(PaginationRequest paginationRequest);

  PostTagUser saveTag(PostTagUser tagUser);

  List<PostTagUser> saveAllTags(List<Long> tagusUserIds, Long postId);

  List<PostTagUser> saveAllTags(List<PostTagUser> tagUsers);

  void deleteAllTag(List<PostTagUser> tagUsers);

  List<PostTagUser> getListTagUser(Long postId, List<Long> blockIds);

  void decrementReactionQuantity(Long id, Long numberOfReactions);

  void incrementReactionQuantity(Long id);

  void decrementCommentQuantity(Long id, Long numberOfComments);

  void incrementCommentQuantity(Long id);
}
